
# **ITAS 188 - Mobile Development I Final Project**

# **Home Movie Catalogue within an app**
# By: Christine Bergen

Having recently obtained a digital copy of old family movies from my childhood, I wanted to create an app that will make accessing and watching these videos easier and so it can be done from anywhere. I also want to make it easily shared with my family members. I have a binder full of information that explains what is on each video segment, along with details about the date, location, and who was there. I'd like to turn this paper record into an electronic record to preserve it and add another backup location. I currently have approx 45 hours of video, and was able to get about 30 minutes of video hosted in Google Cloud and able to be viewed with my app.
  
## Things that were used to accomplish my goal:
 - Internet permissions are used to play videos.
 - Permissions have been set to block the app from playing videos when not connected to WIFI.
 - Videos are hosted in Google Cloud with public URLS. 

## Tutorials/coding assistance for this project
For the actualy media player coding I used this tutorial: How to play video from URL in Android Studio: https://www.geeksforgeeks.org/how-to-play-video-from-url-in-android/
I did also have some help from ChatGPT for the coding to set the restriction so the videos only play while on WIFI and implement the google auth.
I used this tutorial to help with the google authentication: https://www.geeksforgeeks.org/google-signing-using-firebase-authentication-in-android-using-java/

## Screen Shots of the app:
![itas188](https://user-images.githubusercontent.com/119395443/233262794-dfde91a6-03b9-4614-9c75-722e3de8484a.png)
![itas1881](https://user-images.githubusercontent.com/119395443/233262798-32e42ce4-2936-4543-ad19-4c28a95878c5.png)

## Function of the App

The app is fully functional, although currently fairly minimal. I do intend to add more videos as time goes on, and also want to work on getting the google auth to actually verify if users have been granted access to the files so the videos can be changed to private URLs instead of public URLs. I spent some time working on trying to get the video View size to change to full screen when the device is tilted sideways, but I was not able to get that functionality working, although it is a future goal. The share a URL via text message is a neat function which accesses the contacts within the phone and sets a pre-determined message to send (and also a way to bypass the requirement for videos to only play on WIFI).



