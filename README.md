This App is meant for drivers shifts in public transportation. In one day maximum drive time of one driver is 8:00h,
so maximum drivers for one day is three. When we make new line we enter start time and end time of line. We will get
the total time of working hours and number of drivers we need for that line. Dependently of drivers we need for
that line, we will get form for one, two or three drivers. If working hour of driver on that line is smaller then
8:00h on that line, one driver will work. If the total time of line is smaller then 16:00h two driver will work, 
everything above 16:00h three drivers will work.

In the drivers page we will see how much drivers we have avalible.
Those divers will appear in the list for the shifts. For all drivers we have update and delete functions. 
When we have to add new driver we have add button. For every new driver we can add name and last name, and
date of birth. After we add new driver he will apear in the list.

In the lines page we see how many lines do we have, and when the line start and finishes. We can update or delete line. 
We have buttons for add new line and shift table. In the new line section we enter name of line, start time and 
end time of line. From that result we get total time and number of drivers. 

If we want to input shift for line we can do that from line page in the section input shift. When we click on the button,
we can get one two or three drivers input. That depends of number of drivers we are need for that line. 
We can select driver from the select-list.

In the shift section we can see the shifts for lines we have. Changes on shifts can be made only on line section.




To start a web server for the application, run:

    lein ring server

## License

Copyright © 2021 FIXME
