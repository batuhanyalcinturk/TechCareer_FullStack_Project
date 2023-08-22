package com.graysan.bean;

import com.graysan.data.entity.BlogEntity;
import com.graysan.data.entity.CategoryEntity;
import com.graysan.data.repository.IBlogRepository;
import com.graysan.data.repository.ICategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Configuration
@Log4j2
public class CommandLineRunnerBean {

    // Injection
    private final IBlogRepository iBlogRepository;
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // categorySave
    public CategoryEntity categoryEntitySave(String categoryName){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryName);
        iCategoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    public void userData(){
        for (int i = 1; i <= 3; i++) {
            //String user = JOptionPane.showInputDialog(i + ".ci Kategori adını yazınız");
            Scanner scanner = new Scanner(System.in);
            System.out.println(i + ".ci Kategori adını yazınız");
            String userName = scanner.nextLine().toUpperCase();
            categoryEntitySave(userName);
        }
    }

    // Kategori Listesi
    public Iterable<CategoryEntity> categoryEntitiesList(){
        return iCategoryRepository.findAll();
    }

    @Bean
    @Transactional // save, delete, update
    public void blogCategorySave() {
        // Kategory oluştursun ve listelesin
        userData();
        Iterable<CategoryEntity> categoryListIterable = categoryEntitiesList();
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        categoryListIterable.forEach(categoryEntityList::add);

        // Blog oluşturmak (1)
        BlogEntity blogEntity1=new BlogEntity();
        blogEntity1.getBlogEntityEmbeddable().setHeader("header-1");
        blogEntity1.getBlogEntityEmbeddable().setContent("içerik-1");
        if(categoryEntityList!=null){
            blogEntity1.setRelationCategoryEntity(categoryEntityList.get(0)); //ilk kategoriyi
            iBlogRepository.save(blogEntity1);
        }


        // Blog oluşturmak (2)
        BlogEntity blogEntity2=new BlogEntity();
        blogEntity2.getBlogEntityEmbeddable().setHeader("header-2");
        blogEntity2.getBlogEntityEmbeddable().setContent("içerik-2");
        if(categoryEntityList!=null){
            blogEntity2.setRelationCategoryEntity(categoryEntityList.get(1)); //ilk kategoriyi
            iBlogRepository.save(blogEntity2);
        }

        // BlogListesi
        categoryEntityList.forEach(System.out::println);
        System.out.println(blogEntity1);
        System.out.println(blogEntity2);
    }

    // CLR
    public CommandLineRunner commandLineRunnerMethod(){
        return args -> {
            log.info("Data set oluşturulmuştur");
            blogCategorySave();
        };
    }
}
