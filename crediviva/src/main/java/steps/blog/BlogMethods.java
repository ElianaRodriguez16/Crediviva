package steps.blog;

import objects.blog.BlogScreen;

public class BlogMethods {
    BlogScreen blogPage = new BlogScreen();

    public void navigateToBlog(){

        blogPage.goWebPage();
        blogPage.setClave("Crediviva");
        blogPage.clickLinkCrediviva();
        blogPage.clickLinkBlog();
        
    }
}
