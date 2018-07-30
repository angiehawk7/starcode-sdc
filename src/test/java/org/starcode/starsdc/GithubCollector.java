package org.starcode.starsdc;

import com.alibaba.fastjson.JSON;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.util.Collection;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/20 15:49
 * 描述:xxx
 */
public class GithubCollector {
    private static GitHubClient client=new GitHubClient();;
    static{
        //client.setOAuth2Token("ae06199d9cee7a6069ef1a8c84f9f839fb669711");
    }
    public static void main(String[] args) throws Exception {
        collectProject();
    }

    /**
     * 获取github项目信息
     */
    private static void collectProject(){
        RepositoryService service = new RepositoryService();
        PageIterator<Repository> values= service.pageAllRepositories(0);
        Collection<Repository> repos=values.next();
        System.out.println("total size="+repos.size());
        for(Repository repo:repos){
            //System.out.println(repo.getId()+"   "+repo.getName()+"  "+repo.getLanguage());
            System.out.println(JSON.toJSONString(repo));
        }
        System.out.println("total========="+service.pageAllRepositories().iterator().hasNext());
    }

    private static void collectPerson(){

    }
}
