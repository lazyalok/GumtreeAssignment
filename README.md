There are three Fields in file and accordingly I have created three object

* Name
* Gender
* DateOfBirth

Each class is in their own package.
1. DateOfBirth and age related classes are in age package
2. Gender in Gender package
3. Name is also in separate package so that in future if any changes required related with name we can do it without disturbing any other class or package.
4. File reading and populating are in addressbook package

Most of the scenario tried to covered in tests but for convenience provided 1 extra Main class which have main method.
When we Run that class we will get below sysout answers in console.

* There are 3 male gender in given list
* Oldest person in given address book list is : Wes Jackson
* Bill is 2862 days older than Paul

**Future improvement scope::**

I have divided all functionalities in different Finder classes like AgeFinder,GenderFinder etc.
There is scope for refactoring using some interface and all finders can implement that interface and this will 
give us flexibility to use some behavioural patterns when code get more complex.

**Refactored code - 22March**

As mentioned earlier, I have refcatored code to implement Finder interface

Now each class GenderFinder, PersonNameFinder, DaysOlderFinder, OldestPersonFinder, DaysOlderFinder all are Finder Type

Now Finder call based on type what we are looking for and will give response.
