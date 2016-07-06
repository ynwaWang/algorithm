package ynwa.fuji.leetcode;

import java.util.*;

/**
 * Created by ynwa on 16/7/6.
 * https://leetcode.com/problems/design-twitter/
 */

public class Twitter {
    private static int timeStamp = 0;

    public static final int RECENT_T_NUMBER = 10;

    // easy to find if user exist
    private Map<Integer, User> userMap;

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(0);
        twitter.postTweet(0);
        twitter.follow(0,1);
        twitter.follow(0,2);
        twitter.postTweet(1);
        twitter.postTweet(2);
        twitter.postTweet(1);
        twitter.postTweet(2);
        twitter.postTweet(1);
        twitter.postTweet(1);
        twitter.postTweet(1);
        twitter.postTweet(2);
        twitter.postTweet(1);
        twitter.postTweet(2);
        twitter.postTweet(2);

        List<Integer> res = twitter.getNewsFeed(0);
        res.size();
    }

    // Tweet link to next Tweet so that we can save a lot of time
    // when we execute getNewsFeed(userId)
    private static class Tweet {
        public int time;
        public Tweet next;

        public Tweet() {
            time = timeStamp++;
            next = null;
        }
    }


    // OO design so User can follow, unfollow and post itself
    public static class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
            //TODO  tweeted a welcome tweet,so every user have a tweet even if he/she haven't tweet yet
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }


        // everytime user post a new tweet, add it to the head of tweet list.
        public void post() {
            Tweet t = new Tweet();
            t.next = tweet_head;
            tweet_head = t;
        }
    }


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post();

    }


    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this
    // heap before we get the 10 most recent tweet.
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) return Collections.EMPTY_LIST;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(RECENT_T_NUMBER,
                new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet o1, Tweet o2) {
                        return o2.time - o1.time;
                        // (a, b) -> (b.time - a.time)
                    }
                }
        );
        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if (t != null) {
                q.add(t);
            }
        }

        // 这里可以用贪心算法,第一轮是把10个用户的第一条tweet放入res
        // 第二轮是需要在每个用户的tweet链路上延伸,此时需要判断每次的min

        // OR
        // 利用每次queue的insert都会重新排序,
        // 每次先执行一次poll,如果t.next != NULL则执行offer
        // 这样执行10次就能获得有序的10条tweet
        List<Integer> res = new LinkedList<>();
        int min = Integer.MIN_VALUE;





        do {
            Tweet t = q.poll();
            if (res.size() < RECENT_T_NUMBER) {
                res.add(t.time);
            } else {
                for (int i = RECENT_T_NUMBER - 2; t.time > res.get(i) ; i--) {

                }

            }

            if(res.size() >= RECENT_T_NUMBER) min = res.get(RECENT_T_NUMBER - 1);
        } while (!q.isEmpty() || q.peek().time > min);


//        int userCount = 0;
//        while (!q.isEmpty() && userCount < 10) {
//            Tweet t = q.poll();
//            res.add(t.id);
//            userCount++;
//            if (t.next != null)
//                q.add(t.next);
//        }

        return res;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
