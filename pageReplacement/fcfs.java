/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class fcfs {
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of frames:");
        int noFrames=s.nextInt();
        System.out.println("enter the size of reference string:");
        int sizeRS=s.nextInt();
        int RString[]=new int[sizeRS];
        System.out.println("enter the reference string space separated:");
        for(int i=0;i<sizeRS;i++){
            RString[i]=s.nextInt();
        }
        int frames[]=new int[noFrames];
        boolean hashTable[]=new boolean[100];
        Arrays.fill(hashTable,false);
        Arrays.fill(frames,-1);
        int cur=0;
        int pageFaults=0;
        int pageHit=0;
        for(int i=0;i<sizeRS;i++){
            System.out.print(RString+" : ");
             if(hashTable[RString[i]]){
               pageHit++;
             }else{
             pageFaults++;
             if(frames[cur]==-1){
                  frames[cur]=RString[i];
                  hashTable[RString[i]]=true;
                  cur++;
              }else{
                  int temp=frames[cur];
                  frames[cur]=RString[i];
                  hashTable[temp]=false;
                  hashTable[frames[cur]]=true;
                  cur++;
              }
             }
              if(cur>=noFrames){
                cur=0;
              }
              for(int j=0;j<noFrames;j++){
                System.out.print(frames[j]+" ");
              }
              System.out.println();
        }
        System.out.println("pageHits:"+pageHit+" pageFaults : "+pageFaults);
        
	}
}