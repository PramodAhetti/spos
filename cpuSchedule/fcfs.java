/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class fcfs {
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of process:");
        int no=s.nextInt();
        Integer arrival[]=new Integer[no];
        int burst[]=new int[no];
        for(int i=0;i<no;i++){
            System.out.println("Enter arrival time for "+(i+1)+":");
            arrival[i]=s.nextInt();
            System.out.println("Enter burst time for "+(i+1)+":");
            burst[i]=s.nextInt();
        }
        for(int i=0;i<no;i++){
            for(int j=i;j<no;j++){
                if(arrival[i]>arrival[j]){
                   int temp=arrival[i];
                   arrival[i]=arrival[j];
                   arrival[j]=temp;
                   temp=burst[i];
                   burst[i]=burst[j];
                   burst[j]=temp;
                }
            }
        }
        int completeTime=0;
        System.out.println("AT BT CT TAT WT");
        for(int i=0;i<no;i++){
            if(completeTime>=arrival[i]){
                 completeTime+=burst[i];
            }else{
                 completeTime=arrival[i]+burst[i];
            }
            System.out.println(arrival[i]+"  "+burst[i]+"  "+completeTime+"   "+(completeTime-arrival[i])+"   "+(completeTime-burst[i]-arrival[i]));
        }

	}
}