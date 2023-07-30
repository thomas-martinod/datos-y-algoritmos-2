def main():
    A_string = input("Enter the array of integers in the format [a,b,c,d,...,z]: ")
    try:
        A = [int(x) for x in A_string[1:-1].split(',')]
    except:
        print("The ordered list of integers is: " + A_string)
        quit()

    QuickSort(A, 0, len(A)-1)
    print(A)

def QuickSort(A: list, p: int, r: int) -> None:
    if p < r:
        q = Partition(A, p, r)
        QuickSort(A, p, q-1)
        QuickSort(A, q+1, r)


def Partition(A: list, p: int, r: int) -> int:
    x = A[r]
    i = p-1
    for j in range(p, r): # Exclusive range in python [p, r-1] = [p, r)
        if A[j] <= x:
            i = i+1
        
            temp = A[i]
            A[i] = A[j]
            A[j] = temp
        
    temp = A[i+1]
    A[i+1] = A[r]
    A[r] = temp

    return i+1

main()
