# Lab-9

Dylan did the file reading



Jimmy did the ranking




Kyrin implemented the testing

We didnt edit eachothers work, So all of our functions are solely that indiviudals contriubtion.

Data Structures and Order:

For the method that calculates the movies We use a a treeSet and a list. The list is useed for counting term frequencys and the treeSet stores movie names. After all the
movie names have been stored it does a retain all operation to save all the common movies. This simplified list is then iterated through and the frequency is counted for
each term using the frequency list. 

I predict this would be O(N) because the loops arent nested and refer to different control variables.

For the classes internal data structure we used a Map<String, TreeSet<String>>. In this structure the String is the name of the student and the TreeSet<String> is
the list of movies that perso wants to watch.


