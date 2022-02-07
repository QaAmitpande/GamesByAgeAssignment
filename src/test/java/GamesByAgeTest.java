import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamesByAgeTest {
    @Test
    public void SortStudentAgeIngroup(){
        int[]arr={21,22,23,25,20,24,19,18};
        List<Integer> expectedStudentGroup1=new ArrayList<>();
        expectedStudentGroup1.add(18);
        expectedStudentGroup1.add(19);
        expectedStudentGroup1.add(20);
        List<Integer> expectedStudentGroup2=new ArrayList<>();
        expectedStudentGroup2.add(21);
        expectedStudentGroup2.add(22);
        expectedStudentGroup2.add(23);
        List<Integer> expectedStudentGroup3=new ArrayList<>();
        expectedStudentGroup3.add(24);
        expectedStudentGroup3.add(25);
        List<List<Integer>> expectedStudentGroupList=new ArrayList<>();
        expectedStudentGroupList.add(expectedStudentGroup1);
        expectedStudentGroupList.add(expectedStudentGroup2);
        expectedStudentGroupList.add(expectedStudentGroup3);

        Arrays.sort(arr);
        int first=arr[0];
        List<List<Integer>> actualStudenGroupList=new ArrayList<>();
        List<Integer> actualStudentGroup=new ArrayList<>();
        actualStudentGroup.add(first);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-first<=2){
                actualStudentGroup.add(arr[i]);
            }
            else {
                actualStudenGroupList.add(actualStudentGroup);
                actualStudentGroup=new ArrayList<>();
                first= arr[i];
                actualStudentGroup.add(first);
            }
        }
        actualStudenGroupList.add(actualStudentGroup);
        System.out.println(actualStudenGroupList);

        int i=0;
        for (List<Integer>expectedGroup: expectedStudentGroupList){
            int j=0;
            for(Integer expectedMember:expectedGroup){
                Assert.assertEquals(actualStudenGroupList.get(i).get(j++),expectedMember);
            }
            i++;
        }
   }

}
