package org.starcode.starsdc.connector;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 14:14
 * 描述:xxx
 */
public interface IConnector {

    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */

    void stop();
    /**
     * 执行
     * @param request
     * @return
     */
    ResponseEntity execute(RequestEnity request);
}
