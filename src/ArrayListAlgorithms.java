import java.util.ArrayList;

public class ArrayListAlgorithms {
    public static boolean containsTarget(ArrayList<String> stringList, String target) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).indexOf(target) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int belowAverage(ArrayList<Integer> intList) {
        int count = 0;
        double average = 0;
        for (Integer number : intList) {
            average += number;
        }
        average /= intList.size();
        for (Integer number : intList) {
            if (number < average) {
                count++;
            }
        }
        return count;
    }

    public static void replaceWithCaps(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).substring(wordList.get(i).length() - 1).equals("s")) {
                wordList.set(i, wordList.get(i).toUpperCase());
            }
        }
    }

    public static int indexOfMinimum(ArrayList<Integer> intList) {
        int min = 9999999;
        int minIndex = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) < min) {
                min = intList.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2) {
        for (int i = 0; i < numList1.size(); i++) {
            if (numList1.get(i) != numList2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void removeOdds(ArrayList<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 != 0) {
                numList.remove(i);
                i--;
            }
        }
    }

    public static void wackyVowels(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).contains("a") || wordList.get(i).contains("e") || wordList.get(i).contains("i")
                    || wordList.get(i).contains("o")) {
                wordList.remove(i);
                i--;
            } else if (wordList.get(i).contains("u") || wordList.get(i).substring(wordList.get(i).length()).equals("y")) {
                wordList.add(i, wordList.get(i));
                i++;
            } else {
                wordList.add(i, wordList.get(i));
                i++;
            }
        }
    }

    public static void duplicateUpperAfter(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            wordList.add(i + 1, wordList.get(i).toUpperCase());
            i++;
        }
    }

    public static void duplicateUpperEnd(ArrayList<String> wordList) {
        int length = wordList.size();
        for (int i = 0; i < length; i++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
    }

    public static ArrayList<String> parseWordsAndReverse(String sentence) {
        ArrayList<String> reverse = new ArrayList<String>();
        String temp = sentence;
        for (int i = sentence.length(); i > 0; i--) {
            if (sentence.substring(i - 1, i).equals(" ")) {
                reverse.add(temp.substring(i, temp.length()));
                temp = temp.replace(temp.substring(i - 1, temp.length()), "");
            }
        }
        reverse.add(sentence.substring(0, temp.length()));
        return reverse;
    }

    public static void removeDuplicates(ArrayList<Integer> intList) {
        int current = 0;
        for (int i = 0; i < intList.size(); i++) {
            current = intList.get(i);
            for (int x = 0; x < intList.size(); x++) {
                if (current == intList.get(x) && x != i) {
                    intList.remove(x);
                    x--;
                }
            }
        }
    }

    public static void moveBWords(ArrayList<String> wordList) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).substring(0, 1).equals("b")) {
                temp.add(wordList.get(i));
                wordList.remove(i);
                i--;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            wordList.add(0, temp.get(i));
        }
    }

    public static ArrayList<Integer> modes(int[] numList) {
        int count = 0;
        int maxCount = 0;
        int exiled = 0;
        ArrayList<Integer> mode = new ArrayList<Integer>();
        for (int i = 0; i < numList.length; i++) {
            for (Integer num : numList) {
                if (num == numList[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode.clear();
                if (!mode.contains(numList[i])) {
                    mode.add(numList[i]);
                }
            } else if (count == maxCount) {
                if (!mode.contains(numList[i])) {
                    mode.add(numList[i]);
                }
            } else {
                exiled++;
            }
            count = 0;
        }
        if (exiled < 1) {
            mode.clear();
        }
        return mode;
    }

    public static void sortStudents(ArrayList<Student> studentsToSort) {
        Student temp;
        for (int a = 0; a < studentsToSort.size(); a++) {
            for (int i = 0; i < studentsToSort.size(); i++) {
                if (studentsToSort.get(a).getLastName().compareTo(studentsToSort.get(i).getLastName()) < 0) {
                    temp = studentsToSort.get(a);
                    studentsToSort.set(a, studentsToSort.get(i));
                    studentsToSort.set(i, temp);

                } else if (studentsToSort.get(a).getLastName().compareTo(studentsToSort.get(i).getLastName()) == 0) {
                    if (studentsToSort.get(a).getFirstName().compareTo(studentsToSort.get(i).getFirstName()) < 0) {
                        temp = studentsToSort.get(a);
                        studentsToSort.set(a, studentsToSort.get(i));
                        studentsToSort.set(i, temp);

                    } else if (studentsToSort.get(a).getFirstName().compareTo(studentsToSort.get(i).getFirstName()) == 0) {
                        if (studentsToSort.get(a).getGpa() > studentsToSort.get(i).getGpa()) {
                            temp = studentsToSort.get(a);
                            studentsToSort.set(a, studentsToSort.get(i));
                            studentsToSort.set(i, temp);
                        }
                    }
                }
            }
        }
    }
}

