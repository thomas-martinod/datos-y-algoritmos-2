-- Define the QuickSort function
quickSort :: Ord a => [a] -> [a]
quickSort [] = [] -- Base case: an empty list is already sorted
quickSort (x:xs) =
    let smallerSorted = quickSort [a | a <- xs, a <= x]
        biggerSorted = quickSort [a | a <- xs, a > x]
    in smallerSorted ++ [x] ++ biggerSorted

main :: IO ()
main = do
    let unsortedList = [65, 99, 12, 54, 12, 233, 9, 1, -9]
    let sortedList = quickSort unsortedList
    putStrLn "Unsorted List:"
    print unsortedList
    putStrLn "Sorted List:"
    print sortedList

