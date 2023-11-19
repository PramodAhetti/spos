/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Priority {
    public static int least(int curtime,int no,int arrival[],int priority[],int flag[]){
            int index=-1;
            int mPriority=0;
            for(int i=0;i<no;i++){
                      if(flag[i]==1 && arrival[i]<=curtime){
                        if(mPriority<=priority[i]){
                            mPriority=priority[i];
                            index=i;
                        }
                      }
            }
            if(index!=-1){
               flag[index]=0;

            }
            return index;
    }
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of process:");
        int no=s.nextInt();
        int processId[]=new int[no];
        int arrival[]=new int[no];
        int priority[]=new int[no];
        int burst[]=new int[no];
        for(int i=0;i<no;i++){
            processId[i]=1;
            System.out.println("Enter arrival time for "+(i+1)+":");
            arrival[i]=s.nextInt();
            System.out.println("Enter burst time for "+(i+1)+":");
            burst[i]=s.nextInt();
            System.out.println("Enter priority for "+(i+1)+":");
            priority[i]=s.nextInt();        
        }
        for(int i=0;i<no;i++){
            for(int j=i;j<no;j++){
                if(arrival[i]>arrival[j]){

                   int temp=burst[i];
                   burst[i]=burst[j];
                   burst[j]=temp;
                   temp=priority[i];
                   priority[i]=priority[j];
                   priority[j]=temp;
                   temp=arrival[i];
                   arrival[i]=arrival[j];
                   arrival[j]=temp;
                }
            }
        }
        int completeTime=0;
        int count=0;
        System.out.println("AT  BT  PT");
        for(int i=0;i<no;i++){

            System.out.println(arrival[i]+"    "+burst[i]+"   "+priority[i]);
        }

        System.out.println("after scheduling:");
        System.out.println("AT  BT  PT CT TAT");
        while(count<no){
            int temp=least(completeTime,no,arrival,priority,processId);
            if(temp!=-1){
                 System.out.println(arrival[temp]+"    "+burst[temp]+"  "+priority[temp]+"   "+(completeTime+burst[temp])+"   "+(completeTime+burst[temp]-arrival[temp]));
                 completeTime+=burst[temp];
                 count++;
            }else{
                completeTime++;
            }
        }

	}
}