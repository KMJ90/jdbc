package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매여부를 입력 받기 (Scanner 이용) */
        Scanner sc = new Scanner(System.in);

        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        System.out.print("메뉴 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        System.out.print("카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();

        System.out.print("판매 여부를 결정하세요(y/n) : ");
        sc.nextLine();  // 개행문자 : 버퍼에 개행문자가 남아있기 때문에 제거하기 위해

        // toUpperCase() : 사용자가 입력한 문자열을 모두 대문자로 반환
        String orderableStatus = sc.nextLine().toUpperCase();

        // MenuDTO 객체를 생성해서 입력받은 값으로 setting
        MenuDTO newMenu = new MenuDTO();

        newMenu.setMenuName(menuName);  // newMenu 라는 객체의 메뉴이름(속성)을 menuName 으로 설정하거나 초기화하는 형태
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderableStatus(orderableStatus);

        // InsertController 의 insertMenu() 메소드 호출
        InsertController ic = new InsertController();
        int result = ic.insertMenu(newMenu);

        // insert 결과에 따라 성공이면 메뉴 등록 성공!, 실패이면 메뉴 등록 실패! 출력
        if (result > 0) {
            System.out.print("메뉴 등록 성공!");

        } else {
            System.out.print("메뉴 등록 실패ㅠㅠ!");
        }
    }
}
