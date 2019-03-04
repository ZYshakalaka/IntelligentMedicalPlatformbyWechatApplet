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
    listData: []

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    this.setData({
      listData: [
        { "code": "体温(°)", "text": all.user_tem, "type": "36~37" },
        { "code": "心率(次/分)", "text": all.user_rate, "type": "60~100" },
        { "code": "收缩压(mmHg)", "text": all.user_press_h, "type": "≤130" },
        { "code": "舒张压(mmHg)", "text": all.user_press_l, "type": "≤85" }
      ],
      score: all.score,
      id: all.id,
      sex: all.sex,
      age: all.age,
      map: all.map,
      time: all.time
    })
  },

  openAlert: function () {
    wx.showModal({
      content: '您本次健康检查评估分数为'+all.score+'分(满分100)',
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