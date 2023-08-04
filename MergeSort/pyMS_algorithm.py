def main ():
    A_string = input("Enter the array of integers in the format [a,b,c,d,...,z]: ")
    try:
        A = [int(x) for x in A_string[1:-1].split(',')]
    except:
        print("The ordered list of integers is: " + A_string) # Handling the empty []
        quit()

    MergeSort(A, 0, len(A)-1)
    print(A)

def MergeSort (A: list, p: int, r: int) -> None:
    if p >= r:
        return
    else:
        q = int((p+r)/2)

        MergeSort(A,p,q)
        MergeSort(A,q+1,r)
        Merge(A,p,q,r)


def Merge (A: list, p: int, q: int, r: int) -> None:
    nL = q - p + 1
    nR = r - q

    L = [0 for i in range(nL)]
    R = [0 for i in range(nR)]

    for i in range(nL):
        L[i] = A[p+i]
    for j in range(nR):
        R[j] = A[q+j+1]

    i,j,k = 0,0,p

    while (i<nL and j<nR):
        if L[i] <= R[j]:
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1

        k+=1

    while i < nL:
        A[k] = L[i]
        i += 1
        k += 1

    while j < nR:
        A[k] = R[j]
        j += 1
        k += 1
    
main()