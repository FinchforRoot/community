package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czb
 * @Description 封装分页对象
 * @date 2020/1/8 14:32
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    //上一页<
    private boolean showPrevious;
    //下一页>
    private boolean showNext;
    //是否回到首页<<
    private boolean showFirstPage;
    //是否回到最后一页>>
    private boolean showEndPage;
    //当前页
    private Integer page;
    //给前端展示的页码[1,2,3,4,5]
    private List<Integer> pages = new ArrayList<>();
    //totalPage 当前页面下显示几个分页按钮
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        /*
         * totalCount 记录总数
         * page 当前页数
         * size 展示几条记录
         */
        //totalPage 当前页面下显示几个分页按钮
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        this.page = page;
        pages.add(page);
        /* 这个循环做的事情是：先把当前页面插入到给前端展示的页码[当前页码]
         * 如果当前页码减去1，大于0，那么pages=[当前页码-1，当前页码]，就把这个新页码插入到当前页码的前面
         * 否则的话说明这次的这个页码比1小，那么只能在后面插入了
         * 所以进入第二个判断语句：
         * 如果当前页码+1小于分出的页码个数，那么就插入到当前页码的后面：那么pages=[当前页码，当前页码+1]
         */
        for (int i = 1; i < 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == totalCount) {
            showNext = false;
        } else {
            showNext = true;
        }

        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
