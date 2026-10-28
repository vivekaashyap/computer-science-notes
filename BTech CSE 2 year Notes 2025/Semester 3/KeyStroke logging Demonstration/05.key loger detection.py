import hashlib
import os
import psutil
import requests
import logging

def encrypt_data(data):
    encrypted_data = hashlib.sha256(data.encode()).hexdigest()
    return encrypted_data

def restrict_access(file_path):
    os.chmod(file_path, 0o600)  
    
def monitor_processes():
    for proc in psutil.process_iter(['pid', 'name']):
        print(f"Process ID: {proc.info['pid']}, Name: {proc.info['name']}")

def send_data(data):
    url = "webside link"
    response = requests.post(url, data=data)
    return response.status_code

def setup_logging():
    logging.basicConfig(filename='keylogger.log', level=logging.INFO)

def log_activity(activity):
    logging.info(activity)

def main():
        
    setup_logging()
    
    sensitive_data = "Hello, World!"
    encrypted_data = encrypt_data(sensitive_data)
    print(f"Encrypted Data: {encrypted_data}")

    restrict_access('keylogger.log')

    monitor_processes()
    status_code = send_data(encrypted_data)
    print(f"Status Code: {status_code}")

    log_activity("Keylogger started")

if __name__ == "__main__":
    main()