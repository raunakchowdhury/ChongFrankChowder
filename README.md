# ChongFrankChowder
Brandon Chong, Oliver Frank, Raunak Chowdhury  
Lab 00  
2018-02-09

#### Goal:
We want to determine the worst-case execution time of our search method for an n*n matrix.

#### Hypothesis:
For an n\*n matrix, the worst-case execution time of our search method is `O(n)`.

#### Background:
After coding the `MatrixFinder` class to always run in `O(n)`, in it's worst case senario, we wanted to design an experiment to test the MatrixFinder. We put our knowledge on the Java Language and our over-caffinated, Stuyvesant brains to work. To begin our experiment, we needed a populate method that would create a matrix sorted by row and column such that a worst case senario for runtime exists. Our populate method creates a matrix of size n\*n such that each cell is incremented by two from the previous cell. This means as you go down a column or right along a row, each successive cell would be an integer two greater than the previous.

#### Experiment Methodology
We populated Matrices of size n\*n and tested the runtime of the MatrixFinder in its worse case senario. The sizes of matrices we used ranged from intervals of 10 between 1000 to 2000. We decided to chose between 1000 to 2000 as our levels because anything smaller than 1000 is relatively small and insignificant, however and because if we went above 10000 we would lose in the interest of time. We wrote the resulting times for each size matrix into a csv file, with the horizontal axis as **n**, and the vertical axis as runtime in milliseconds. 

#### Results
Based on the graph that we created, our results look linear. The **Trials** corresponds to **Levels**.

![](OliverFrankGraph.png)  
![](RaunakChowdhuryGraph.png)  
![](BrandonChongGraph.png)  

#### Conclusions
The graphs by Oliver and Raunak were both similar, in that they look very closely realated to a linear line graph. Few fluctuations occured in these two data sets. However, the graph from Brandon still looks liner but has a lot more varaiation. One possibility for this was Brandon could have accidentally had differences in his test that Raunak and Oliver had. Also, the look of the graphs could vary depending on which program we used to create the graph or which computing device we used to compile and run `MFDriver`. Our next step would be to increase the amount of sizes of matrices we tested. We would also like to try another populate method that can find worse case runtime.  
If you would like to try to run the same experiment as we did, you may clone this repository. Once you change your directory into ChongFrankChowder, do: 
```
javac MFDriver.java
java MFDriver
```    
It should automatically create a csv file in the repo.  
Send us your results or post to the QAF!
