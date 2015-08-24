# PeopleFinder

You will be using the tables created in that project for this one. 
You must create a database with multiple tables in order to get credit for this application.


Create a search form that will allow users to enter a term in a text box and find all the matching last names. If the user enters partial text then the application shall find all companies or last names that contain that text. So Smith will find users named Smith and Smithman.

To search for a partial term in SQL use the LIKE operator with the wildcard character %. 
The percent sign will match any number of letters. Note that our installation of Oracle is case-sensitive. 
So 'smith' will not match 'Smith'.

So to find all users named Smith use the following SQL statement:

select firstname,lastname from customers where lastname like 'Smith%'

Once the user is found, display a page with the user's details.

Also, several projects have been submitted without closing the database connection. Therefore, you must close the database connection in order to get credit for this application.

