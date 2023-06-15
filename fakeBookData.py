import mysql.connector
from faker import Faker

# Initialize Faker
fake = Faker()

# Setup MySQL connection
db = mysql.connector.connect(
  host="localhost",  # replace with your MySQL server host
  user="root",  # replace with your MySQL username
  password="",  # replace with your MySQL password
  database="bookApi"  # replace with your database name
)

cursor = db.cursor()

# Generate and insert data
for i in range(1, 101):
    author = fake.name()
    title = fake.catch_phrase()
    year_published = fake.year()

    query = "INSERT INTO book (id, author, title, year_published) VALUES (%s, %s, %s, %s)"
    values = (i, author, title, year_published)

    cursor.execute(query, values)

# Commit the transaction
db.commit()

# Close the connection
cursor.close()
db.close()
