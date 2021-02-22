# tech-mat

Task 1 -**Functional Exercise**
**Test case design**
Test cases to verify valid maze program---------

#no	Scenario
1	Verify the maze size 
2	Verify the maze has one entry point at upper left
3	Verify the maze has one exit point at lower right
4	Verify the shortest path in maze to reach the exit point
5	Verify the longest path in maze to reach the exit point
6	Verify the path which never leads to exit point
7	Verify the width between each cell is constant
8	Verify the arrow keys are used for movement in maze
9	Verify the valid maze has no loops i.e.a location appears at most once in the path.
10	Verify the valid maze has no inaccessible areas
11	Verify the cursor can move either directly north, south , east , west
12	Verify the path must start at the entry (upper left corner) of the maze.
13	Verify the path must end at the exit (lower right corner) of the maze.
14	Verify each location in the path is within the maze bounds
15	Verify each location in the path is an open corridor (not wall).
16	Verify each location is one cardinal step (N,S,E,W) from the next in path
17	Verify if path ends at exit, path is a solution
18	Verify if path doesnot ends in exit- visit the cell which has an open wall, is in one of the four viable directions & cell has not been visited yet
19	Verify each maze row is required to have same length as all the others.
20	Verify every cell is connected to every other cell

------------------------------------------------------------------------------------------------------------------------------------------------------------------
Task 3 - **Front End automation**
App under test: https://www.etsy.com
IDE: IntelliJ
Languages: java
Tools used : **webdriver + gradle **

**Tests methods created in selenium**
Search for ‘Sketchbook’
sort results by price ascending
add the most expensive item to the cart
search for ‘turntable mat’
add any ‘turntable mat’ to cart
validate the number of items in cart

**Dependencies used**
Selenium test ---Implementation group: 'org.testng', name: 'testng', version: '6.14.3'
Testng  ----implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '3.141.59'

----------------------------------------------------------------------------------------------------------------------------------------------------------------


