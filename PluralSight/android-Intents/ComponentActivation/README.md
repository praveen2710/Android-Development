# Component Activation
This app will use intents to create instance of components of various type i.e
Activity,Service,Broadcast Reciever

## Addtional Features
* Use single intent to create activity instance and prevent multiple instance's of the activity from being created by multiple intent.Rather once the activity is created by one intent use the other intents to use same activity instance
* Listen to system's **airplane notification** and incorporate that in the app
* Add logging to indicate process and thread running using the component
* Have intent filter's in *AndroidManifest.XML* for various components 

## Code links

## Development Updates
* Added the initial commit
* Added functionality to call implicit activity and service with custom menu options
* Added functionality to call service explicitly
* Added broadcast receiver to detect airplane mode toggling 
* Added mutplie activites from single intent
* Added funtionlaity to access external URL using in-built activity

## Doubts and question
* use of constructor vs onCreate in service?
* prevent multiple instances of activity from being generated?
* issue when calling service explicitly
* ~~not seeing receiver work when app is not running~~
    1. The log show it is working but since the app is not longer running the debugger detaches from the application and does not hit the break point.