This app Kinship of RecyclerView is implemeting different 
variations/usescases of recyclerView I'm aware so for.
1st kind-> a normal recycler view with a ItemDecorator
2nd kind -> recyclerView containing cardview with OnClick enabled on cardView
3rd kind-> recyclerview containing individual textview & imageView of check mark 
it's visibility is set according to selection made by user and only one can be 
selected once.
4th Kind-> recyclerView with multi-viewtypes at once it is implemented by using two viwholders
since two different viewtypes are used and custom giveItemViewType() is used to fit our requirement.
5th kind -> similar to 3rd Kind made tweaks to its Adapter to make multiple selections.
6th Kind -> similar to 5th kind but added swipe functionality where swipe to left, it deletes the data and 
presents us a SnackBar and an action to undo it; Swipe to right is for toggle the selection if the unselected is swiped right
it gets selected and vice-versa.

<video src="https://github.com/sanjuray/KinshipOfRecyclerView/assets/94555333/dc5d114f-a436-41fd-a88d-86c41ea30552" width=450 height=500/>



