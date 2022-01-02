"""
    File name: SQLInjectionExample.py
    Author: Zachary N. Brown
    Description: This application demonstrates 
    CWE-89: Improper Neutralization of Special 
    Elements used in an SQL Command ('SQL Injection')
    and a mitigation.
"""

import mysql.connector

# connects to the mysql db instance
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="kLyi8%tR$htUpW@q",
  database='Customers'
)

# curser object to communiacate with the db instance and execute commands
mycursor = mydb.cursor()

mycursor.execute("CREATE DATABASE Customers")

mycursor.execute("CREATE TABLE customers (name VARCHAR(50), SSN VARCHAR(20))")

sql = "INSERT INTO customers (name, SSN) VALUES (%s, %s)"
val = [
  ('Zach', '424356756'),
  ('Bryan', '354676520'),
  ('Aric', '127364584'),
  ('Mike', '687947563'),
  ('Brandon', '458375649'),
  ('Alan', '475869437')
]

mycursor.executemany(sql, val)

# commit function to apply the new table
mydb.commit()

# vulnerable query that allows a user to input/inject any kind of SQL commands
query = "SELECT * FROM customers WHERE name ='tom' or '1'='1'"
mycursor.execute(query)

# prepared/parameterized query that prevents SQL injection
query = "SELECT * FROM customers WHERE name = %s"
name = input("Enter name:")

if re.match('$') not in name:
  mycursor.execute(query, name)

else: print("Invalid name")

myresult = mycursor.fetchall()

# lists the customers
for x in myresult:
  print(x)
