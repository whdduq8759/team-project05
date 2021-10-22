package com.project.blog.Makeblog.controller;


import com.project.blog.Makeblog.domain.Blog;
import com.project.blog.Makeblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BlogController {

    private final BlogService blogService;
    /////////////////////////////////////// 기본 설정 //////////////////////////////////////////


/*    // 1.게시물 목록 조회 요청
    @GetMapping("/list")
    public String list(Model model) {
        log.info("/board/list GET 요청 발생");
        List<Blog> articles = blogService.getArticles();
        model.addAttribute("articles", articles);

        return "board/list";
    }*/

    // 2. 게시물 상세 조회 요청
    @GetMapping("/single")
    public String content(int serialNo, int categoryNo, Model model) {
        log.info("/board/content GET 요청! - 글번호: " + serialNo);
        Blog content = blogService.getContent(serialNo, categoryNo);
        int viewCount = blogService.upViewCount(serialNo);
        model.addAttribute("article", content);
        model.addAttribute("articles", viewCount);


        return "board/single";
    }

    // 게시물 등록페이지로 이동
    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    // 3. 게시물 등록 요청
    // return값은 임의로 movie-list로 설정 해뒀습니다.
    // 기본값 : redirect:/board/list
    @PostMapping("/write")
    public String write(Blog blog, RedirectAttributes ra) {
        log.info("/board/write POST 요청! - " + blog);
        blogService.insert(blog);

        return "redirect:/board/movie-list";
    }

    // 4. 게시물 삭제 요청
    // return값은 임의로 movie-list로 설정 해뒀습니다.
    // 기본값 : redirect:/board/list
    @GetMapping("/delete")
    public String delete(int serialNo) {
        log.info("/board/delete GET ! - " + serialNo);
        blogService.remove(serialNo);
        return "redirect:/board/movie-list";
    }

    // 게시물 수정페이지로 이동
    @GetMapping("/modify")
    public String modify(int serialNo, int categoryNo, Model model) {
        log.info("/board/modify GET! - " + serialNo);
        Blog content = blogService.getContent(serialNo, categoryNo);
        model.addAttribute("article", content);
        return "board/modify";
    }

    // 5. 게시물 수정 요청
    @PostMapping("/modify")
    public String modify(Blog blog) {
        log.info("/board/modify POST! - " + blog);
        log.info(blog.getSerialNo());
        blogService.modify(blog);
        return "redirect:/board/single?serialNo=" + blog.getSerialNo() + "&categoryNo=" + blog.getCategoryNo();
    }





/*    // 6. 조회수 상승 요청
    @GetMapping("/single")
    public String upViewCnt(int serialNo, Model model) {
        model.addAttribute("articles", blogService.upViewCount(serialNo));
        return "board/single";
    }*/


    /////////////////////////// 카테고리 /////////////////////////////////////////

    // 카테고리(영화)로 이동
    @GetMapping("/movie-list")
    public String movieList(Model model, Blog blog) {
        log.info("/board/movie-list GET 요청 발생");
        List<Blog> articles = blogService.getMovieArticles();
        log.info(articles);
        model.addAttribute("article", articles);

        List<Blog> bestArticles = blogService.getMovieBestArticle();
        model.addAttribute("bestArticles", bestArticles);
        log.info(blog.getSerialNo());


        model.addAttribute("flag", "movie");

        return "board/list";
    }

    // 카테고리(맛집)로 이동
    @GetMapping("/restaurant-list")
    public String restaurantList(Model model, Blog blog) {
        log.info("/board/restaurant-list GET 요청 발생");
        List<Blog> articles = blogService.getRestaurantArticles();
        model.addAttribute("article", articles);

        List<Blog> bestArticles = blogService.getRestaurantBestArticle();
        model.addAttribute("bestArticles", bestArticles);
        log.info(blog.getSerialNo());


        model.addAttribute("flag", "res");

        return "board/list";
    }

    // 카테고리(일상)로 이동
    @GetMapping("/daily-list")
    public String dailyList(Model model, Blog blog) {
        log.info("/board/daily-list GET 요청 발생");
        List<Blog> articles = blogService.getDailyArticles();
        model.addAttribute("article", articles);
        log.info(blog.getSerialNo());

        List<Blog> bestArticles = blogService.getDailyBestArticle();
        model.addAttribute("bestArticles", bestArticles);

        model.addAttribute("flag", "day");

        return "board/list";
    }

    // 카테고리(전체 조회)로 이동
    @GetMapping("/guest-book")
    public String guestList(Model model) {
        log.info("/board/guest-book GET 요청 발생");

        List<Blog> articles = blogService.getAllArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("flag", "all");

        return "board/all-list";
    }

}
