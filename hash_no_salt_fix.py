"""
    File name: hash_no_salt_fix.py
    Description: This application demonstrates 
    how to mitigate CWE-759: Use of a One-Way Hash 
    without a Salt by using a stronger hashing
    algorithm with a salt for stored user credentials.
"""

import hashlib
import sys
import os

database = {}

def sign_up(database):
    
    print("Welcome! Please sign up first.")
    username = input("Please enter a usename:" )
    password = input("Enter your password:" ) 
    
    # generate random number for the salt
    salt = os.urandom(32) 
    # use a better hash algorithm and encode
    key = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 100000)
    # update database dictionary with hash and salt
    database[username] = { 
     'salt' : salt,
     'key' : key
    }
    
    login(database)
    
def login(database):
    
    username = input("Please enter your username:" )
    password = input("Enter your password:" ) 
    
    # extract salt and key from known credentials
    salt = database[username]['salt'] 
    key = database[username]['key'] 
    new_key = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 100000)
    
    # compare credentials using the key
    if key == new_key:
        print("Login Success!")
        sys.exit()
    
    # display error if login does not match stored credentials
    else: print("Invalid Credentials.")
    login(database)
    
sign_up(database)
