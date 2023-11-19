/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class sjf {

    public static int least(int completeTime,int no,int arrival[],int burst[],int flag[]){
            int minIndex=-1;
            int minValue=1000;
            for(int i=0;i<no;i++){
                if(flag[i]==1 && burst[i]<=minValue && arrival[i]<=completeTime){
                  minIndex=i;
                  minValue=burst[i];
                }
            }

            return minIndex;
    }
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of process:");
        int no=s.nextInt();
        int arrival[]=new int[no];
        int flag[]=new int[no];
        int burst[]=new int[no];
        int ogburst[]=new int[no];
        int cTime[]=new int[no];
        int taTime[]=new int[no];
        int waiting[]=new int[no];
        int visited[]=new int[no];
        for(int i=0;i<no;i++){
            System.out.println("Enter arrival time for "+(i+1)+":");
            arrival[i]=s.nextInt();
            System.out.println("Enter burst time for "+(i+1)+":");
            burst[i]=s.nextInt(); 
            ogburst[i]=burst[i]; 
            waiting[i]=0;
            visited[i]=-1; 
        }
        Arrays.fill(flag,1);
        int completeTime=0;
        int count=0;
        while(count<no){
             
             int temp=least(completeTime,no,arrival,ogburst,flag);
             System.out.println(temp+" "+completeTime);
             burst[temp]--;
             if(visited[temp]==-1){
                visited[temp]=completeTime;
                waiting[temp]+=completeTime-arrival[temp];
             }else{
             waiting[temp]+=(completeTime-visited[temp]-1);
             visited[temp]=completeTime;
             }
             completeTime++;
             if(burst[temp]<=0){
                System.out.println("here : "+temp+" "+completeTime);
                count++;
                flag[temp]=0;
                cTime[temp]=completeTime;
                taTime[temp]=cTime[temp]-arrival[temp];
             }
             
             
        }
      System.out.println("AT  BT  CT  TAT");
      for(int i=0;i<no;i++){
        System.out.println(arrival[i]+"   "+ogburst[i]+"   "+cTime[i]+"     "+taTime[i]+"    "+waiting[i]);
      }
	}
}