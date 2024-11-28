# Raven Challenge

* Language: Kotlin
* MVVM + Clean Architecture
* Unit Testing: View Model
* Jetpack Compose

## App structure:

* Hilt was used as a dependency injector and is implemented with a separate module for better concern handling
* For networking Retrofit was used respectively
* To handle asynchronization, kotlin coroutines were used
* Finally, to carry out the unit tests, MockK was used

For the consumption of services, we used a Repository pattern that goes very well with Clean, as an extra, we used a SplashScreen using the Google library in which it is no longer necessary to use a direct class for its implementation.

For the database part, Room was used. 

The Repository design pattern was used in which, separating the remote/local logic with a DataSource, we ensure that whenever the information is downloaded from the service it is stored in the base and the list that will paint the view is obtained from it.

Given that the information for the view is always obtained from the DB inside data we make a validation so that obtaining the list of the eliminated news, even when the service downloads the information, we compare with the id what we have eliminated and this way we only show what has an isActive status inside the view.

Within the DB we use flow to ensure the speed at which the user sees the change of data, both when the news is deleted and when it is updated.

For the deletion it is given in a logical way adding a field isActive to be able to show those that are active, if it is deleted it stops at 0 and with this it is still in the DB but it is not shown.


## Demo

https://github.com/user-attachments/assets/313030fa-5630-4170-b833-8bfb56383cfe


## BD


![RavenChallengeDB](https://github.com/user-attachments/assets/8535a3f0-a526-48cf-be57-d51cc89e7048)



## Extras

For the Swipe delete part, a small animation was added to provide a more “natural” user experience and not just a “blinking” effect in which information is displayed and disappears, this animation allows the user to see how to swipe and scroll up the list in a more “natural” way.

## Notes

Here are some points of improvement as next steps refining a little bit the HU:

* It is required to add an error message when there is no internet and the DB is empty, this in order to show a retry.
* It is necessary to add error messages in case of failure (both in the database and in the service).
* It is necessary to add tests to the UseCase.
* Since the service uses pagination, we can use paginationFlow to show more data. 


