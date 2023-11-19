/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class lru {
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
        boolean hashTable[]=new boolean[100];
        Arrays.fill(hashTable,false);
        int pageFaults=0;
        int pageHit=0;
        LinkedList<Integer> frames=new LinkedList<>();
        for(int i=0;i<sizeRS;i++){
             if(hashTable[RString[i]]){
               frames.remove(RString[i]);
               frames.addLast(RString[i]);
               pageHit++;
             }else{
               pageFaults++;
               if(frames.size()<noFrames){
                   frames.addLast(RString[i]);
                   hashTable[RString[i]]=true;
               }else{
                   hashTable[frames.removeFirst()]=false;
                   frames.addLast(RString[i]);
                   hashTable[RString[i]]=true;
               }
             }
              for(int j:frames){
                System.out.print(j+" ");
              }
              System.out.println();
        }
        System.out.println("pageHits:"+pageHit+" pageFaults : "+pageFaults);
        
	}
}