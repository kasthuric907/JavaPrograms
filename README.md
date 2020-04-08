# JavaPrograms
The given java program finds the mutiple train paths from Delhi to Chennai via,Pune or Nagpur or Vizag or Hyderbad
It also arranges the various routes possible in non-decreasing order of paths.

Input format:
5     //no of routes as input						
Delhi  Pune   160                   
Nagpur  Chennai  80 	
Delhi  Hyderabad  100		 
Pune  Nagpur  90
Vizag  Chennai  120 
Space separated string values 
“<Boarding station><space><Destination station><space><cost>”
  NOTE : The city name must start with the capital letter and should have proper spelling.

Various possible inputs:
.……….……………………………………………...……………………………………………..……………………………………..

6
Pune Chennai 190
Delhi Hyderabad 55
Nagpur Pune 70
Delhi Nagpur 50
Pune Nagpur 85
Hyderabad Nagpur 80
     
.……….……………………………………………...……………………………………………..……………………………………..
   
6
Hyderabad Delhi 55
Delhi Nagpur 73
Hyderabad Nagpur 88
Vizag Pune 89
Hyderabad Chennai 44
Nagpur Vizag 54
.……….……………………………………………...……………………………………………..……………………………………..
6
Delhi Nagpur 70
Nagpur Chennai 30
Vizag Chennai 30
Delhi Vizag 70
Delhi Hyderabad 70
Hyderabad Chennai 30
.……….……………………………………………...……………………………………………..……………………………………..
6
Delhi Nagpur 66
Pune Nagpur 66
Chennai Pune 66
Vizag Chennai 39
Delhi Vizag 40
Nagpur Chennai 70
.……….……………………………………………...……………………………………………..……………………………………..
7
Vizag Nagpur 50
Nagpur Pune 44
Hyderabad Nagpur 72
Delhi Vizag 76  
Hyderabad Chennai  44
Pune Vizag 60
Nagpur Hyderabad 92
