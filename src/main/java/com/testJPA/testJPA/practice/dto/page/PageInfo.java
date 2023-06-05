package com.testJPA.testJPA.practice.dto.page;

import org.springframework.data.domain.Page;


public class PageInfo<T> {

    private int startPage;
    private int endPage;
    private int currentPage;

    private boolean prev;
    private boolean next;

    private int totalCount;

    private static final int PAGE_LEN = 10;

    public PageInfo(Page<T> page) {
        this.totalCount = (int) page.getTotalElements();
        this.prev = page.hasPrevious();
        this.next = page.hasNext();
        this.currentPage = page.getPageable().getPageNumber();
        // 현재 나는 10page 중 7번 페이지에있다 endPage 를 구해라!
        // 7/10 올림 * page_len
        this.endPage = (int) (Math.ceil((double) this.currentPage / PAGE_LEN) * PAGE_LEN);
        this.startPage = endPage - PAGE_LEN + 1;

        int finalPage = page.getTotalPages();
        if(finalPage<this.endPage){
            this.endPage=finalPage;
        }

    }
}
