# Analog Clock

This project represent a Analog Clock.

## AnalogClock Class
AnalogClock Class is responsible to create the dial and update the hours.
This Class extends swing JFrame component.
## ClockDial Class

ClockDial class is responsible to paint the clock component. This class draw the dial, digital clock and hour, minute and second hands.
This class extends JPanel to be add in the AnalogClock.
## Just build it!
```
$ mvn clean package
```

## And see what you got!
```
$ ls -1 target
```

## Generate JavaDocs
Api docs pah:
```
target/site/apidocs/
```
Commant to generate javadoc:
```
$ mvn javadoc:javadoc
```

## To run the application 
```
$ java -jar target/analog-clock-1.0.0-executable.jar
```


## Total time spend
```
2 hours
```
