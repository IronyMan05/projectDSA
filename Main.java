//CLI based
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println("***Welcome To Algorithm Simulator***");
        while(true)
        {
            System.out.println("\n1. Bubble Sort");
            System.out.println("2. Merge two sorted array");
            System.out.println("3. Binary Search");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            ch=sc.nextInt();
            System.out.print("\n");
            if(ch==0)
            {
                System.out.println("***Thank You for using Algorithm Simulator***");
                break;
            }
            switch(ch)
            {
                case 1:
                    System.out.print("Enter Size of the Array : ");
                    int n=sc.nextInt();
                    int arr[]=new int[n];
                    for(int i=0;i<n;i++)
                    {
                        System.out.print("Enter element "+(i+1)+" : ");
                        arr[i]=sc.nextInt();
                    }
                    bubbleSort(arr);
                    break;
                case 2:
                    System.out.println("Note : The array you enter must be sorted in ascending order.");
                    System.out.print("Enter Size of the Array 1 : ");
                    int n1=sc.nextInt();
                    int a1[]=new int[n1];
                    int a11[]=new int[n1];
                    for(int i=0;i<n1;i++)
                    {
                        System.out.print("Enter element number "+(i+1)+" : ");
                        a1[i]=sc.nextInt();
                        a11[i]=a1[i];
                    }
                    Arrays.sort(a11);
                    System.out.print("Enter Size of the Array 2 : ");
                    int n2=sc.nextInt();
                    int a2[]=new int[n2];
                    int a22[]=new int[n2];
                    for(int i=0;i<n2;i++)
                    {
                        System.out.print("Enter element number "+(i+1)+" : ");
                        a2[i]=sc.nextInt();
                        a22[i]=a2[i];
                    }
                    Arrays.sort(a22);
                    boolean f1=true, f2=true;
                    for(int i=0;i<n1;i++)
                    {
                        if(a1[i]!=a11[i])
                        {
                            f1=false;
                            break;
                        }
                    }
                    for(int i=0;i<n2;i++)
                    {
                        if(a2[i]!=a22[i])
                        {
                            f2=false;
                            break;
                        }
                    }
                    if(f1==false || f2==false)
                    {
                        System.out.println("The array you entered is not sorted in ascending order.");
                        System.out.println("Do you want us to sort it for you and proceed with merging?");
                        System.out.print("Enter your choice (y/n) : ");
                        while(true)
                        {
                            char c=sc.next().charAt(0);
                            if(c=='Y' || c=='y')
                            {
                                mergeSortedArray(a11, a22);
                                break;
                            }
                            else if(c=='N' || c=='n')
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid choice, please re-enter your choice (y/n) : ");
                            }
                        }
                        break;
                    }
                    mergeSortedArray(a1, a2);
                    break;
                case 3:
                    System.out.println("Note : The array you enter must be sorted in ascending order.");
                    System.out.print("\nEnter size of the Array : ");
                    int len=sc.nextInt();
                    int ar[]=new int[len];
                    int ar1[]=new int[len];
                    for(int i=0;i<len;i++)
                    {
                        System.out.print("Enter element number "+(i+1)+" : ");
                        ar[i]=sc.nextInt();
                        ar1[i]=ar[i];
                    }
                    Arrays.sort(ar1);
                    System.out.print("\nEnter number to search : ");
                    int key=sc.nextInt();
                    boolean flag=true;
                    for(int i=0;i<len;i++)
                    {
                        if(ar1[i]!=ar[i])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag==false)
                    {
                        System.out.println("\nThe array you entered is not sorted in ascending order.");
                        System.out.println("Do you want us to sort it for you and proceed with Binary search?");
                        System.out.print("Enter your choice (y/n) : ");
                        while(true)
                        {
                            char c=sc.next().charAt(0);
                            if(c=='Y' || c=='y')
                            {
                                binarySearch(ar1, key);
                                break;
                            }
                            else if(c=='N' || c=='n')
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid choice, please re-enter your choice (y/n) : ");
                            }
                        }
                    }
                    else
                    {
                        binarySearch(ar, key);
                    }
                    break;
                default:
                    System.out.println("Invalid Choice, please re-enter choice");
            }
        }
    }
    static void bubbleSort(int arr[])
    {
        int swap=0;
        System.out.print("\nOriginal Array : ");
        printArray(arr,arr.length);
        for (int i = 0; i < arr.length; i++)  
        {  
            for (int j = i + 1; j < arr.length; j++)  
            {  
                if (arr[j] < arr[i])  
                {
                    System.out.print("\n"+arr[i]+" > "+arr[j]+"  Swap");
                    int temp = arr[i];  
                    arr[i] = arr[j];  
                    arr[j] = temp;
                    swap++;
                }
                else
                {
                    System.out.print("\n"+arr[i]+" < "+arr[j]+"  No Swap");
                }
            }
            System.out.print("\nPass "+(i+1)+" : ");
            printArray(arr,arr.length);
            System.out.print("\nTotal swap after pass "+(i+1)+" : "+swap);
            swap=0;
            System.out.println();
        }
        System.out.print("\n\nFinal array after applying Bubble sort : ");
        printArray(arr,arr.length);
        System.out.println();
        System.out.println("\nSome additional information about bubble sort :");
        System.out.println("> The Time complexity (worst case) of Bubble Sort is O(n^2).");
        System.out.println("> The Space complexity of Bubble Sort is O(1).");
        System.out.println("> The algorithm gets its name because smaller elements 'Bubble' to the top of the list during each pass.");
        System.out.println("\n_________________________________________________________________________________________________________");
    }
    static void mergeSortedArray(int a1[], int a2[])
    {
        int a3[]=new int[(a1.length+a2.length)];
        int i=0,j=0,c=0;
        System.out.print("\nFirst array : ");
        printArray(a1,a1.length);
        System.out.println();
        System.out.print("\nSecond array : ");
        printArray(a2,a2.length);
        System.out.println();
        while(i<a1.length && j<a2.length)
        {
            if(a1[i]<a2[j])
            {
                a3[c++]=a1[i++];
            }
            else
            {
                a3[c++]=a2[j++];
            }
            System.out.print("\nMerged Array after "+c+" iteration : ");
            printArray(a3,c);
            
        }
        if(a1.length==i)
        {
            for(int k=j;k<a2.length;i++)
            {
                a3[c++]=a2[j++];
            }
            System.out.print("\nSince element of Array 1 is finished we will copy all the remaining element of Array 2 in merged array.");
            System.out.print("\nFinal Merged Array : ");
            printArray(a3,a3.length);
        }
        else
        {
            System.out.print("\nSince element of Array 2 is finished we will copy all the remaining element of Array 1 in merged array.");
            System.out.print("\nFinal Merged Array : ");
            for(int k=i;k<a1.length;k++)
            {
                a3[c++]=a1[i++];
            }
            printArray(a3,a3.length);
        }
        System.out.println("\n> The Time complexity of merging two sorted array is always linear.");
        
        System.out.println("\n\n_________________________________________________________________________________________________________");
    }
    static void binarySearch(int ar[], int key)
    {
        int start=0;
        int end=ar.length-1;
        boolean flag=false;
        System.out.print("\nArray : ");
        printArray(ar,ar.length);
        System.out.println("\nKey : "+key);
        while(start<=end)
        {
            int mid=(start+end)/2;
            System.out.print("\nSearching from index "+start+" to "+end);
            System.out.print("\nMiddle Index : "+ mid +"     Middle element : "+ar[mid]+"     and Key : "+key);
            if(ar[mid]==key)
            {
                System.out.print("\nMiddle Element = Key");
                System.out.println("\nElement found at index : " +mid);
                flag=true;
                break;
            }
            else if(ar[mid]>key)
            {
                System.out.print("\nMiddle Element > Key");
                System.out.print("\nEnd = Middle - 1");
                end=mid-1;
            }
            else
            {
                System.out.print("\nMiddle Element < Key");
                System.out.print("\nStart = Middle + 1");
                start=mid+1;
            }
        }
        if(flag==false)
        {
            System.out.println(key+" does not exist in given array.");
        }
        System.out.println("\n> The Time complexity of Binary search is O(log n) where 'n' is number of element in the array.");
        System.out.println("\n_________________________________________________________________________________________________________");
    }
    static void printArray(int array[], int length)
    {
        for(int i=length-1;i>=0;i--)
        {
            System.out.print(array[i]+" ");
        }
    }
}
