
### Project: iDrop-swing- Desktop iRODS transfer manager and supporting libraries
#### Date: 
#### Version: 4.2.0.1-SNAPSHOT
#### Git Tag: MASTER 

iDrop is a graphical multi-platform file transfer client suitable for moving large files, doing basic synchronization, and other
tasks too 'heavy' for a standard web interface

This interface is being revived and will become part of the regular Jargon release train starting with 4.2.0.1

GitHub:  [[https://github.com/DICE-UNC/idrop]]

## Requirements

-iDrop depends on Java 1.8+
-iDrop is built using Maven

iDrop-swing uses Maven for dependency management.  See the pom.xml file for references to various dependencies.

Note that the following bug and feature requests are logged in GForge with related commit information [[https://code.renci.org/gf/project/irodsidrop/tracker/]]

## Changes

#### Add negotiation drop down to grid config #130 

Now support SSL negotiation settings per grid account
