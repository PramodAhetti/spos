/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class opr {
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
        int curIndex=0;
        for(int i=0;i<sizeRS;i++){
          if(curIndex<noFrames){
             pageFaults++;
             frames[curIndex]=RString[i];
             hashTable[RString[i]]=true;
             curIndex++;
          }else{
            if(hashTable[RString[i]]){
               pageHit++;
            }else{
                pageFaults++;
               int last=-1;
               int replaceIndex=0;
               for(int j=0;j<noFrames;j++){
                boolean flag=true;
                for(int k=i;k<sizeRS;k++){
                    if(frames[j]==RString[k]){
                        flag=false;
                        if(k>last){
                            last=k;
                            replaceIndex=j;
                        }
                        break;
                    }
                }
                if(flag){
                    replaceIndex=j;
                    break;
                }
               }

                int random=frames[replaceIndex];
                frames[replaceIndex]=RString[i];
                hashTable[RString[i]]=true;
                hashTable[random]=false;
            
            }
          }
          System.out.print(RString[i]+" : ");
          for(int bin:frames){
            System.out.print(bin+" ");
          }
          System.out.println();
        }
        System.out.println("pageHits:"+pageHit+" pageFaults : "+pageFaults);
        
	}
}