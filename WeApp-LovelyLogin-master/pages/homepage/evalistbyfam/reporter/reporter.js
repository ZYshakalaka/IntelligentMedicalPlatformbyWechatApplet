var all = getApp().globalData;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    score: '',
    id:'',
    sex:'',
    age:'',
    map:'',
    time:'',
    listData: [],
    evalid:'',
    user_tem:'',
    tem_describe:'',
    user_rate:'',
    rate_describe:'',
    user_press_l:'',
    user_press_h:'',
    press_describe:'',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    var that = this;
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/eval/findevalpage.do',
      data: {
        id: e.evalid,
      },
      success: function (res) {
        //console.log('usertem:' + res.data.user_tem);
        that.setData({
          score:res.data.score,
          time: res.data.time,
          sex: res.data.sex,
          user_id:res.data.user_id,
          map:res.data.map,
          age:res.data.age,
        })
        all.tem_describe=res.data.tem_describe,
        all.rate_describe=res.data.rate_describe,
        all.press_describe=res.data.press_describe,

        that.setData({
          listData: [
            { "code": "体温(°)", "text": res.data.user_tem, "type": "36~37" },
            { "code": "心率(次/分)", "text": res.data.user_rate, "type": "60~100" },
            { "code": "收缩压(mmHg)", "text": res.data.user_press_h, "type": "≤130" },
            { "code": "舒张压(mmHg)", "text": res.data.user_press_l, "type": "≤85" }
          ],
        })

      }
    })
  },

  openAlert: function () {
    wx.showModal({
      content: '本次健康检查评估分数为'+this.data.score+'分(满分100)',
      showCancel: false,
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
        }
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})