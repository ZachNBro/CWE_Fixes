"""
    File name: HashNoSalt.py
    Description: This application demonstrates 
    CWE-759: Use of a One-Way Hash without a Salt
    by using an oudating hashing algorithm with
    no salt for a stored username and password.
"""

import hashlib
import sys

database = {}

def sign_up(database):
    
    print("Welcome! Please sign up first.")
    username = input("Please enter a usename:" )
    password = input("Enter your password:" )
    
    # using inferior sha1 hash algorithm without salt
    hash_password = hashlib.sha1(password.encode())
    hex_dig = hash_password.hexdigest()
    
    # update database with entered credentials
    database.update([(username, hex_dig)])
    print(database)
    login(database)
    
def login(database):
    # assign temporary login key/value pair for comparison
    temp_login = {}
    
    print("Please login.")
    login_username = input("Please enter your username:" )
    login_password = input("Please enter your password:" )
    
    # hash login password to compare to stored password
    hash_password = hashlib.sha1(login_password.encode())
    hex_dig = hash_password.hexdigest()
    
    # update temporary login credentials
    temp_login.update([(login_username, hex_dig)])
    print(temp_login)
    
    # compare credentials
    if temp_login == database:
        print("Login Success!")
        sys.exit()
    
    # display error is login does not match stored credentials
    else: print("Invalid Credentials.")
    login(database)
    
sign_up(database)
