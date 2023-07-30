## Roughgarden naive Partition

def main():
    A_string = input("Enter the array of integers in the format [a,b,c,d,...,z]: ")
    try:
        A = [int(x) for x in A_string[1:-1].split(',')]
    except:
        print("The ordered list of integers is: " + A_string)
        quit()

    print(QuickSort(A))

def QuickSort(A: list) -> list:
    if (len(A) != 0 and len(A) != 1):
        q, A_new = Partition(A)
        leftA = QuickSort(A_new[:q])
        rightA = QuickSort(A_new[q+1:])
        return (leftA + [A_new[q]] + rightA)
    else:
        return A


def Partition(A: list) -> (int, list):
    x = A[0] # Pivot as first element
    A_new = [0 for i in range(len(A))]

    front = 0
    back = -1
    
    for i in range(1,len(A)):

        if A[i] <= x:
            A_new[front] = A[i]
            front += 1

        else:
            A_new[back] = A[i]
            back -= 1
    
    A_new[front] = x
    return front, A_new

    
main()