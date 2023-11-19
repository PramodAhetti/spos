/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class sjf {
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of process:");
        int no=s.nextInt();
        Integer process[]=new Integer[no];
        int burst[]=new int[no];
        for(int i=0;i<no;i++){
            process[i]=i+1;
            System.out.println("Enter burst time for "+(i+1)+":");
            burst[i]=s.nextInt();
        }
        for(int i=0;i<no;i++){
            for(int j=i;j<no;j++){
                if(burst[i]>burst[j]){
                   int temp=process[i];
                   process[i]=process[j];
                   process[j]=temp;
                   temp=burst[i];
                   burst[i]=burst[j];
                   burst[j]=temp;
                }
            }
        }
        int completeTime=0;
        System.out.println("Id Bt Wt Tat");
        for(int i=0;i<no;i++){
            completeTime+=burst[i];
            System.out.println(process[i]+"  "+burst[i]+"  "+(completeTime-burst[i])+" "+(completeTime));
        }

	}
}