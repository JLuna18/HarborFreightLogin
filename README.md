Created a simple framework that focuses on the Harbor Freight login page. (User must have chromedriver.exe in downloads folder OR update filepath in BaseTest.java line 47.)

note: chromedriver.exe that I used can be downloaded by pasting this url in browser and then moving .exe from the zip to the downloads folder: https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.109/win64/chromedriver-win64.zip

Users can kick off the test by right clicking 'testng.xml', and selecting run.

It will pull up the login page and call the action method that will enter the sample email address, password, and then click login (that will fail as of now since I am not using a valid account.)
