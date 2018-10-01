# DirectoryREST
Repo for a simple Directory Listing REST Service

Building should be relatively straightforward, using maven and docker

using the following commands:

--mvn install dockerfile:build

and

--docker run -p 8080:8080 -t springio/folder-info-rest-service

then navigate to http://localhost:8080/info
add ?directoryPath= to specify the path, the default is set to /bin because that had some files and folders in it in the docker container (it seems to have it's own file system, which... makes sense now that I know kinda how Docker works).



My knowledge of Docker and even implementing REST services is... limited, so this is in all honestly, somewhat cobbled together from tutorials and documentation I could find on the subject.
This being said, it appears to work without noticeable hitches, and I couldn't break it outside of trying to list the files in the /proc folder, which seems to fall over as I'm guessing (my limited knowledge here) the processes that are finished remove the folders, and it was hitting an issue with one of them dissapearing at the wrong moment.
I have not tested it on Windows, so I don't know if the \ folder seperator will cause issues (I'd guess so? I haven't escaped it or anything, so it's probably going to fall over, but I've kinda run out of available time to throw at this, as I had less time than I'd planned... life eh?).
