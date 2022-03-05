# medianSort
improvmentOfQuickSort

the median sort is a sorting algorithms similar to quick sort and trys to get better performance by choosing better pivot to avoid the worst case sinario that quick sort faces 

### the mechanism :

first call of the medSort will find the min and max items in the list, thats done using one loop and then call the the other medSort which input is the array,start point ,end point
,min item ,max item which is calculated before .

this method call will starts by calculating the median of the array portion form start to end which is equal to (min+max)/2 
and then it will pass throw the array element by element and if the element is greater than the median it will be added to the end of the array .

the method will be re called for the left and the right side of the new array.

the termination will be done if the length of the array portion less that 2 or elements are equal which is represented by  if (min==max)return; 
and if the length of the portion is 2 it will be swaped if needed and then return.

### test 

// bound  of random 1000000000

1 million items 

quicksort :            124 894 400ns
enhanced medsort :     140  108  700ns

100k items 

quicksort :  19 625 300 ns  
medsort :    22 721 600 ns

1k items 

quicksort :  1 411 900ns
medsort :    1 581 900ns

100 000 random items 

median sort : 49 389 900ns
quick sort :  18 210 800ns


### illustration:

### first call 

![image](https://user-images.githubusercontent.com/83182202/156874477-a449efa2-903e-4f16-a47d-4a920d779d9d.png)

### the items that are greater than the median are added last 
![image](https://user-images.githubusercontent.com/83182202/156874652-bb2cdcec-0350-431c-8065-361ca6819cb1.png)

### recursive calls of left and right 
![image](https://user-images.githubusercontent.com/83182202/156874874-6fc1a475-2496-49f7-a78a-29cf5e050011.png)

### right recursive call 
![image](https://user-images.githubusercontent.com/83182202/156875121-0ea7ca29-de40-44a6-bdcb-f549d192ce3c.png)

### left recursive call 
![image](https://user-images.githubusercontent.com/83182202/156881381-137c71a3-dbd6-4653-b401-8b61b8015ff1.png)

### final result 
![image](https://user-images.githubusercontent.com/83182202/156881358-cc2982f6-ae7d-444d-b35b-14f17c315288.png)

