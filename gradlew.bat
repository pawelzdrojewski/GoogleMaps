����   4 _
  R S T
  U V W <init> (Landroid/view/View;)V Code LineNumberTable LocalVariableTable this #Landroid/view/ViewPropertyAnimator; view Landroid/view/View; setDuration &(J)Landroid/view/ViewPropertyAnimator; duration J getDuration ()J getStartDelay setStartDelay 
startDelay setInterpolator I(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator; interpolator $Landroid/animation/TimeInterpolator; getInterpolator &()Landroid/animation/TimeInterpolator; setListener Y AnimatorListener InnerClasses R(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator; listener -Landroid/animation/Animator$AnimatorListener; setUpdateListener [ AnimatorUpdateListener ](Landroid/animation/ValueAnimator$AnimatorUpdateListener;)Landroid/view/ViewPropertyAnimator; 8Landroid/animation/ValueAnimator$AnimatorUpdateListener; start ()V cancel x &(F)Landroid/view/ViewPropertyAnimator; value F xBy y yBy z zBy rotation 
rotationBy 	rotationX rotationXBy 	rotationY rotationYBy translationX translationXBy translationY translationYBy translationZ translationZBy scaleX scaleXBy scaleY scaleYBy alpha alphaBy 	withLayer %()Landroid/view/ViewPropertyAnimator; withStartAction 9(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator; runnable Ljava/lang/Runnable; withEndAction 
SourceFile ViewPropertyAnimator.java  , java/lang/RuntimeException Stub!  \ !android/view/ViewPropertyAnimator java/lang/Object ] +android/animation/Animator$AnimatorListener ^ 6android/animation/ValueAnimator$AnimatorUpdateListener (Ljava/lang/String;)V android/animation/Animator android/animation/ValueAnimator !       &      	   B     *� � Y� �    
       9                       	   >     
� Y� �    
       E        
       
        	   4     
� Y� �    
       Q        
         	   4     
� Y� �    
       ]        
         	   >     
� Y� �    
       i        
       
        	   >     
� Y� �    
       v        
       
        	   4     
� Y