package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        // 1. 변경할 메뉴 코드, 이름, 가격을 입력 받기 (Scanner 사용)
        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();

        System.out.print("변경할 메뉴 이름을 입력하세요 : ");
        sc.nextLine();
        String menuName = sc.nextLine();

        System.out.print("변경할 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        // 2. MenuDTO 객체를 생성하여 입력받은 값으로 setting
        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setMenuCode(menuCode);
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(menuPrice);

        // 3. UpdateController 의 updateMenu() 메소드 호출
        UpdateController uc = new UpdateController();
        int result = uc.updateMenu(menuDTO);

        // 4. update 결과에 따라 성공, 실패 메세지 출력
        if (result > 0) {
            System.out.print("수정 성공");
        } else {
            System.out.print("수정 실패");
        }
    }
}
