// news.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchid:'',
    data: [],
    time:'',
  },

  searchInput: function (e) {
    this.setData({
      searchid: e.detail.value
    })
  },

  search: function () {
    console.log(this.data.searchid);
    wx.showToast({
      title: '查询中',
      icon: 'loading',
      duration: 500
    });
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/data/rankbyself.do',
      method: 'GET',
      data: {
        id: this.data.searchid,
      },
      success: function (res) {
        if(res.data.json == ''){
          wx.showModal({
            content: '查询失败！没有该用户！',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              }
            }
          });
        }else{
          wx.showModal({
            content: '查询ID:' + res.data.json[0].userid + '\n' +
            '本周排名第:' + res.data.number + '\n' + '平均分数:'
            + res.data.json[0].score + '分,健康检测次数:' + res.data.json[0].times + '次',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              }
            }
          });WW
        }
      },
      fail: function () {
        wx.showModal({
          content: '查询失败！没有该用户！',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        });
      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.showToast({
      title: '数据加载中',
      icon: 'loading',
      duration: 2000
    });
    wx.request({
      url: 'https://www.zyserverfordevelop.cn/healthcloud/data/rankbyday.do',
      method: 'GET',
      success: function (res) {
        that.setData({
          data: res.data.json,
          time: res.data.time
        })
      }
    })
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