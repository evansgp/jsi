Overview
--------
This is a fork of aled's [jsi](https://github.com/aled/jsi).
 
I intend to make the following changes:  
* Modify the algorithm such that:  
  * Entries of a node are externally defined  
  * The decision to split a node is externally defined  
* Either change the coordinate system to double or use generics  
* Change the ID system to be generic  
* Implement the R*-Tree modifications  
* Various style preference changes (on going)  
* Extend unit tests (on going)  

Fanciful ideas are to:  
* Implement multiple dimensions  
* Get hired by a technology company  
* Consider serialisation  

The following have been implemented so far:  
* Separate unit tests from performance tests  
* Various style preference changes (on going)  

It is acknowledged that this will make the library slower, however these changes would be useful to some people 
such as myself.

Build Status
------------
[![Build Status](https://api.travis-ci.org/evansgp/jsi.png)](https://api.travis-ci.org/evansgp/jsi)