说明
=
由于个人能力有限，不太明白git是怎么使用的，最后还是选择强行传输来保证最后代码的正确运行。  
如果想查看历史commit版本，我们之前测试还有一个分支叫EnglishLearningApp可以查看。  
只是11.22的那个版本和最早一个版本都无法查看了。  
很可惜的一件事吧，这也是本次的不足之处。  
本软件运行环境：android studio 2024.1

----------

最终版本较最开始的版本的修改：  
=
①实现了从Android到Androidx的切换，修改了一些不同步的地方使得可以在androidx的环境下运行；  
②修改了所有页面返回功能缺失的问题；  
③修改了个人隐私页面同意选项缺失的问题；  
④添加了个人资料和编辑资料的两个页面；  
⑤添加了在个人页面跳转到个人资料页面的功能：点击个人姓名或者右上角空白处均可实现；  
⑥解决了年龄可能是负数，以及名字过长会导致显示页面混乱的问题；  
⑦修改了夜间模式切换时候菜单栏和页面显示不同步的问题；  
⑧添加了在名字，学校，签名的回车键退出功能；  
⑨解决了按返回会卡在加载界面和复习界面的问题；  
⑩添加了可以通过相机和相册选择头像的功能。 

----------

还没解决的问题：
=
①头像问题，因为我们的架构问题，在设置个人资料页面的时候，图片的id被设为main了，后面发现想修改id实现头像更换功能，修改了两天还是没成功，要准备期末考试了只能作罢；  
②适配问题，在测试中发现有些型号的手机不支持安装，但负责测试的同学似乎没有注意这个地方，也没提供可能的原因；  
③黑夜模式切换卡顿问题：实际上是有动画设置的，但跟手机性能有关（好像），在我舍友较好的华为手机上测试时，有明显的开关动画以及黑屏转场，在平板上则没有这些，只是卡顿下然后切换；   
④有些型号的手机，在初始界面时，下面的语句无法显示完整，12.10号发现的bug，但来不及修改了，就此作罢；  
⑤在白天模式下有些按钮颜色过暗影响阅读；  
⑥以及没发现的所有问题。

------------

一点点牢骚话
=
都写到这里了我觉得我们组应该也不会来看这个readme文档了我来发发牢骚吧。    
你们都很好，只是不怎么把这个事情放在心上。不要拿什么能力有限来说，我也是从零开始学的。    
谢谢高运圣同学的功能架构的编写，何杰同学初始个人资料和编辑资料功能的添加，李海康同学的测试结果的整理。以及三位同学在文档里的一些贡献。  
除此之外，剩下的功能开发，BUG修正，软件测试，文档里大部分内容，一共13个部分，10到11个部分的内容的编写，都是我做的。  
不是揽功，好吧也有点这个的意味。我不想自己做的东西成为别人的嫁衣。当这个软件能成功运行，解决一个又一个BUG，我的开心是真的无与伦比的。  
这个软件真的，就是我这学期的心血了，我希望他可以得到应有的奖赏，也承受任何的批评。我承认清词还有很多很多的不足，优化空间，但我分不出更多的精力去让这个作品更完整了。  
说是无力感，应该也是吧。到现在12.11下午，晚上就要答辩了，连仅有的几次commit都是我交的。最后实在是搞不清楚如何正常提交，又怕缺了什么文件导致文件无法正常运行影响到他最后的表现，我选择了最不好的强行提交。  
很抱歉让这个软件以这样的形式和大家见面。就连这个readme也是下午我急急忙忙加的。  
希望我在空余下来的时候，真真正正的可以完善好这个软件的全部功能，我真的希望它可以越来越好。  
以上就是我们小组本次Android作品的全部内容。感谢观看。  

------------
