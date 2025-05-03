# MedianSort

The median sort is a sorting algorithm similar to quicksort and tries to achieve better performance by choosing a better pivot to avoid the worst-case scenario that quicksort faces. 
The sort is done in-place, without allocating extra memory for new arrays.

### The mechanism :

The first call to medSort finds the minimum and maximum elements in the list using a single loop. It then calls the overloaded medSort method, which takes the array, start index, end index, and the previously calculated minimum and maximum values as input.

This method begins by calculating the median of the array portion from start to end, using the formula (min + max) / 2. It then iterates through the array elements one by one. If an element is greater than the median, it is moved to the end of the array.

The method recursively calls itself on the left and right portions of the modified array.

The recursion terminates when the length of the current array portion is less than 2, or when all elements are equal (i.e., min == max). If the portion contains exactly two elements, they are swapped if necessary, and the function returns.

### Test 

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


### Illustration:

### first call 

![image](https://user-images.githubusercontent.com/83182202/156881846-f9d4df04-973b-427c-8a78-d894b094aaf9.png)

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

