package com.ohgiraffers.section03.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        // 1. 삭제할 메뉴 코드 입력받기
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 메뉴 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();

        // MenuDTO 객체를 생성하여 입력받은 값으로 setting
//        MenuDTO menuDTO = new MenuDTO();
//
//        menuDTO.setMenuCode(menuCode);

        // 2. DeleteController 의 deleteMenu() 메소드 호출
        DeleteController dc = new DeleteController();
        int result = dc.deleteMenu(menuCode);

        // 3. delete 결과에 따라 성공하면 '메뉴 삭제 성공!' 실패하면 '메뉴 삭제 실패 ㅠ' 출력
        if (result > 0) {
            System.out.print("삭제 성공");
        } else {
            System.out.print("삭제 실패");
        }
        // entry key = "deleteMenu"
    }
}
