package com.zy.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EvaluateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNull() {
            addCriterion("evaluate_time is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNotNull() {
            addCriterion("evaluate_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeEqualTo(Date value) {
            addCriterion("evaluate_time =", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotEqualTo(Date value) {
            addCriterion("evaluate_time <>", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThan(Date value) {
            addCriterion("evaluate_time >", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evaluate_time >=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThan(Date value) {
            addCriterion("evaluate_time <", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThanOrEqualTo(Date value) {
            addCriterion("evaluate_time <=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIn(List<Date> values) {
            addCriterion("evaluate_time in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotIn(List<Date> values) {
            addCriterion("evaluate_time not in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeBetween(Date value1, Date value2) {
            addCriterion("evaluate_time between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotBetween(Date value1, Date value2) {
            addCriterion("evaluate_time not between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapIsNull() {
            addCriterion("evaluate_map is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapIsNotNull() {
            addCriterion("evaluate_map is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapEqualTo(String value) {
            addCriterion("evaluate_map =", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapNotEqualTo(String value) {
            addCriterion("evaluate_map <>", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapGreaterThan(String value) {
            addCriterion("evaluate_map >", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_map >=", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapLessThan(String value) {
            addCriterion("evaluate_map <", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapLessThanOrEqualTo(String value) {
            addCriterion("evaluate_map <=", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapLike(String value) {
            addCriterion("evaluate_map like", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapNotLike(String value) {
            addCriterion("evaluate_map not like", value, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapIn(List<String> values) {
            addCriterion("evaluate_map in", values, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapNotIn(List<String> values) {
            addCriterion("evaluate_map not in", values, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapBetween(String value1, String value2) {
            addCriterion("evaluate_map between", value1, value2, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andEvaluateMapNotBetween(String value1, String value2) {
            addCriterion("evaluate_map not between", value1, value2, "evaluateMap");
            return (Criteria) this;
        }

        public Criteria andTemIsNull() {
            addCriterion("tem is null");
            return (Criteria) this;
        }

        public Criteria andTemIsNotNull() {
            addCriterion("tem is not null");
            return (Criteria) this;
        }

        public Criteria andTemEqualTo(String value) {
            addCriterion("tem =", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotEqualTo(String value) {
            addCriterion("tem <>", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemGreaterThan(String value) {
            addCriterion("tem >", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemGreaterThanOrEqualTo(String value) {
            addCriterion("tem >=", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemLessThan(String value) {
            addCriterion("tem <", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemLessThanOrEqualTo(String value) {
            addCriterion("tem <=", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemLike(String value) {
            addCriterion("tem like", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotLike(String value) {
            addCriterion("tem not like", value, "tem");
            return (Criteria) this;
        }

        public Criteria andTemIn(List<String> values) {
            addCriterion("tem in", values, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotIn(List<String> values) {
            addCriterion("tem not in", values, "tem");
            return (Criteria) this;
        }

        public Criteria andTemBetween(String value1, String value2) {
            addCriterion("tem between", value1, value2, "tem");
            return (Criteria) this;
        }

        public Criteria andTemNotBetween(String value1, String value2) {
            addCriterion("tem not between", value1, value2, "tem");
            return (Criteria) this;
        }

        public Criteria andTemDescribeIsNull() {
            addCriterion("tem_describe is null");
            return (Criteria) this;
        }

        public Criteria andTemDescribeIsNotNull() {
            addCriterion("tem_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTemDescribeEqualTo(String value) {
            addCriterion("tem_describe =", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeNotEqualTo(String value) {
            addCriterion("tem_describe <>", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeGreaterThan(String value) {
            addCriterion("tem_describe >", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("tem_describe >=", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeLessThan(String value) {
            addCriterion("tem_describe <", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeLessThanOrEqualTo(String value) {
            addCriterion("tem_describe <=", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeLike(String value) {
            addCriterion("tem_describe like", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeNotLike(String value) {
            addCriterion("tem_describe not like", value, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeIn(List<String> values) {
            addCriterion("tem_describe in", values, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeNotIn(List<String> values) {
            addCriterion("tem_describe not in", values, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeBetween(String value1, String value2) {
            addCriterion("tem_describe between", value1, value2, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andTemDescribeNotBetween(String value1, String value2) {
            addCriterion("tem_describe not between", value1, value2, "temDescribe");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateDescribeIsNull() {
            addCriterion("rate_describe is null");
            return (Criteria) this;
        }

        public Criteria andRateDescribeIsNotNull() {
            addCriterion("rate_describe is not null");
            return (Criteria) this;
        }

        public Criteria andRateDescribeEqualTo(String value) {
            addCriterion("rate_describe =", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeNotEqualTo(String value) {
            addCriterion("rate_describe <>", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeGreaterThan(String value) {
            addCriterion("rate_describe >", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("rate_describe >=", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeLessThan(String value) {
            addCriterion("rate_describe <", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeLessThanOrEqualTo(String value) {
            addCriterion("rate_describe <=", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeLike(String value) {
            addCriterion("rate_describe like", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeNotLike(String value) {
            addCriterion("rate_describe not like", value, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeIn(List<String> values) {
            addCriterion("rate_describe in", values, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeNotIn(List<String> values) {
            addCriterion("rate_describe not in", values, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeBetween(String value1, String value2) {
            addCriterion("rate_describe between", value1, value2, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andRateDescribeNotBetween(String value1, String value2) {
            addCriterion("rate_describe not between", value1, value2, "rateDescribe");
            return (Criteria) this;
        }

        public Criteria andPressHIsNull() {
            addCriterion("press_h is null");
            return (Criteria) this;
        }

        public Criteria andPressHIsNotNull() {
            addCriterion("press_h is not null");
            return (Criteria) this;
        }

        public Criteria andPressHEqualTo(String value) {
            addCriterion("press_h =", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHNotEqualTo(String value) {
            addCriterion("press_h <>", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHGreaterThan(String value) {
            addCriterion("press_h >", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHGreaterThanOrEqualTo(String value) {
            addCriterion("press_h >=", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHLessThan(String value) {
            addCriterion("press_h <", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHLessThanOrEqualTo(String value) {
            addCriterion("press_h <=", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHLike(String value) {
            addCriterion("press_h like", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHNotLike(String value) {
            addCriterion("press_h not like", value, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHIn(List<String> values) {
            addCriterion("press_h in", values, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHNotIn(List<String> values) {
            addCriterion("press_h not in", values, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHBetween(String value1, String value2) {
            addCriterion("press_h between", value1, value2, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressHNotBetween(String value1, String value2) {
            addCriterion("press_h not between", value1, value2, "pressH");
            return (Criteria) this;
        }

        public Criteria andPressLIsNull() {
            addCriterion("press_l is null");
            return (Criteria) this;
        }

        public Criteria andPressLIsNotNull() {
            addCriterion("press_l is not null");
            return (Criteria) this;
        }

        public Criteria andPressLEqualTo(String value) {
            addCriterion("press_l =", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLNotEqualTo(String value) {
            addCriterion("press_l <>", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLGreaterThan(String value) {
            addCriterion("press_l >", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLGreaterThanOrEqualTo(String value) {
            addCriterion("press_l >=", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLLessThan(String value) {
            addCriterion("press_l <", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLLessThanOrEqualTo(String value) {
            addCriterion("press_l <=", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLLike(String value) {
            addCriterion("press_l like", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLNotLike(String value) {
            addCriterion("press_l not like", value, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLIn(List<String> values) {
            addCriterion("press_l in", values, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLNotIn(List<String> values) {
            addCriterion("press_l not in", values, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLBetween(String value1, String value2) {
            addCriterion("press_l between", value1, value2, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressLNotBetween(String value1, String value2) {
            addCriterion("press_l not between", value1, value2, "pressL");
            return (Criteria) this;
        }

        public Criteria andPressDescribeIsNull() {
            addCriterion("press_describe is null");
            return (Criteria) this;
        }

        public Criteria andPressDescribeIsNotNull() {
            addCriterion("press_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPressDescribeEqualTo(String value) {
            addCriterion("press_describe =", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeNotEqualTo(String value) {
            addCriterion("press_describe <>", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeGreaterThan(String value) {
            addCriterion("press_describe >", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("press_describe >=", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeLessThan(String value) {
            addCriterion("press_describe <", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeLessThanOrEqualTo(String value) {
            addCriterion("press_describe <=", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeLike(String value) {
            addCriterion("press_describe like", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeNotLike(String value) {
            addCriterion("press_describe not like", value, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeIn(List<String> values) {
            addCriterion("press_describe in", values, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeNotIn(List<String> values) {
            addCriterion("press_describe not in", values, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeBetween(String value1, String value2) {
            addCriterion("press_describe between", value1, value2, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andPressDescribeNotBetween(String value1, String value2) {
            addCriterion("press_describe not between", value1, value2, "pressDescribe");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTDescIsNull() {
            addCriterion("t_desc is null");
            return (Criteria) this;
        }

        public Criteria andTDescIsNotNull() {
            addCriterion("t_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTDescEqualTo(String value) {
            addCriterion("t_desc =", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotEqualTo(String value) {
            addCriterion("t_desc <>", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescGreaterThan(String value) {
            addCriterion("t_desc >", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescGreaterThanOrEqualTo(String value) {
            addCriterion("t_desc >=", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLessThan(String value) {
            addCriterion("t_desc <", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLessThanOrEqualTo(String value) {
            addCriterion("t_desc <=", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLike(String value) {
            addCriterion("t_desc like", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotLike(String value) {
            addCriterion("t_desc not like", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescIn(List<String> values) {
            addCriterion("t_desc in", values, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotIn(List<String> values) {
            addCriterion("t_desc not in", values, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescBetween(String value1, String value2) {
            addCriterion("t_desc between", value1, value2, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotBetween(String value1, String value2) {
            addCriterion("t_desc not between", value1, value2, "tDesc");
            return (Criteria) this;
        }

        public Criteria andPDescIsNull() {
            addCriterion("p_desc is null");
            return (Criteria) this;
        }

        public Criteria andPDescIsNotNull() {
            addCriterion("p_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPDescEqualTo(String value) {
            addCriterion("p_desc =", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotEqualTo(String value) {
            addCriterion("p_desc <>", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThan(String value) {
            addCriterion("p_desc >", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThanOrEqualTo(String value) {
            addCriterion("p_desc >=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThan(String value) {
            addCriterion("p_desc <", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThanOrEqualTo(String value) {
            addCriterion("p_desc <=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLike(String value) {
            addCriterion("p_desc like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotLike(String value) {
            addCriterion("p_desc not like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescIn(List<String> values) {
            addCriterion("p_desc in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotIn(List<String> values) {
            addCriterion("p_desc not in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescBetween(String value1, String value2) {
            addCriterion("p_desc between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotBetween(String value1, String value2) {
            addCriterion("p_desc not between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andRDescIsNull() {
            addCriterion("r_desc is null");
            return (Criteria) this;
        }

        public Criteria andRDescIsNotNull() {
            addCriterion("r_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRDescEqualTo(String value) {
            addCriterion("r_desc =", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotEqualTo(String value) {
            addCriterion("r_desc <>", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThan(String value) {
            addCriterion("r_desc >", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThanOrEqualTo(String value) {
            addCriterion("r_desc >=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThan(String value) {
            addCriterion("r_desc <", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThanOrEqualTo(String value) {
            addCriterion("r_desc <=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLike(String value) {
            addCriterion("r_desc like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotLike(String value) {
            addCriterion("r_desc not like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescIn(List<String> values) {
            addCriterion("r_desc in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotIn(List<String> values) {
            addCriterion("r_desc not in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescBetween(String value1, String value2) {
            addCriterion("r_desc between", value1, value2, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotBetween(String value1, String value2) {
            addCriterion("r_desc not between", value1, value2, "rDesc");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}